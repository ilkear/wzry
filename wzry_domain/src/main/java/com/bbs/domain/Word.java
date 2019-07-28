package com.bbs.domain;

public class Word {

    Integer wordId;
    //敏感词
    String word;
    //0,1
    Integer status;
    //是否使用
    String statusStr;
    //操作启用的字符串显示
    String statusUse;

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
                //使用状态(0 启用 1 未启用)
        if(status==0){
            statusStr="使用中";
        }else if(status==1){
            statusStr="已停用";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getStatusUse() {
        //操作(0 启用 1 未启用)
        if(status==0){
            statusUse="停用";
        }else if(status==1){
            statusUse="启用";
        }
        return statusUse;
    }

    public void setStatusUse(String statusUse) {
        this.statusUse = statusUse;
    }


//    public String getStatusStr() {
//
//        //状态(0 启用 1 未启用)
//        if(status==0){
//            statusStr="启用";
//        }else if(status==1){
//            statusStr="未启用";
//        }
//
//        return statusStr;
//    }


}
