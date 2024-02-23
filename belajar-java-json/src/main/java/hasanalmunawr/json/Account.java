package hasanalmunawr.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Account {

    @JsonProperty("User_name") // untuk menyamarkan nama dari name menjadi username
    private String name;
    @JsonIgnore
    private String password; // untuk mengambaikan passwore supaya tidak tampil
    @JsonFormat(pattern = "dd-mm-yyy") // mengatur format date time susuai kebutuhan
    private Date createAt;
    private Date updateAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
