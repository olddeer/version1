CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;



COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

CREATE FUNCTION public.add_star() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	IF OLD.status != 'Done' THEN
		IF NEW.status = 'Done' THEN
			UPDATE pupil SET count_stars = count_stars + 1
			WHERE pupil_id = NEW.pupil_id;
		END IF;
	END IF;
	RETURN NEW;
END;
$$;


ALTER FUNCTION public.add_star() OWNER TO postgres;


CREATE FUNCTION public.control_count_audios() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE
	current_num integer;
	required_num integer;
	current_task_status varchar(20);
BEGIN
	SELECT count INTO required_num
	FROM task_pupil
	WHERE task_pupil_id = NEW.task_pupil_id;
	SELECT COUNT(*) INTO current_num
	FROM result
	WHERE task_pupil_id = NEW.task_pupil_id;
	SELECT status INTO current_task_status
	FROM task_pupil
	WHERE task_pupil_id = NEW.task_pupil_id;

	IF current_task_status = 'In_checking' OR current_task_status = 'Done' THEN
		RAISE EXCEPTION 'All records were done';
	ELSE
		IF required_num - current_num = 1 THEN
			UPDATE task_pupil SET status = 'In_checking'
			WHERE task_pupil_id = NEW.task_pupil_id;
		END IF;
	END IF;

	RETURN NEW;

END;
$$;


ALTER FUNCTION public.control_count_audios() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TRIGGER update_count_stars AFTER UPDATE ON public.task_pupil FOR EACH ROW EXECUTE PROCEDURE public.add_star();




CREATE TRIGGER update_task_status BEFORE INSERT ON public.result FOR EACH ROW EXECUTE PROCEDURE public.control_count_audios();