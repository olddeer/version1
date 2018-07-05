package at.bitmedia.schoolreader.version1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SR_AUDIO")
public class Audio {
    @Id
    private int sra_id;
    private  String path;

    public int getSra_id() {
        return sra_id;
    }

    public void setSra_id(int st_audio) {
        this.sra_id = st_audio;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
