package com.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "border_info")
public class BorderInfo {
    @Id
    @Column(name = "key_word", unique = true, nullable = false)
    private String keyWord;

    @Column(name = "response_ro")
    private String responseRo = "";

    @Column(name = "response_eng")
    private String responseEng = "";

    @Column(name = "response_ru")
    private String responseRu  = "";

    /*public BorderInfo(String keyWord, String responseRo, String responseEng, String responseRu) {
        this.keyWord = keyWord;
        this.responseRo = responseRo;
        this.responseEng = responseEng;
        this.responseRu = responseRu;
    }

    public BorderInfo(String keyWord, String responseRo) {
        this.keyWord = keyWord;
        this.responseRo = responseRo;
    }

    public BorderInfo(String keyWord) {
        this.keyWord = keyWord;
    }*/

    public String getKeyWord() {
        return keyWord;
    }

    public String getResponseRo() {
        return responseRo;
    }

    public String getResponseEng() {
        return responseEng;
    }

    public String getResponseRu() {
        return responseRu;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setResponseRo(String responseRo) {
        this.responseRo = responseRo;
    }

    public void setResponseEng(String responseEng) {
        this.responseEng = responseEng;
    }

    public void setResponseRu(String responseRu) {
        this.responseRu = responseRu;
    }
}
