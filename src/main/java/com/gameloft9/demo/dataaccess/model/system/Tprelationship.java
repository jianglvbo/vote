package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tprelationship implements Serializable {

   private int rid;
   private int subtitleId;
   private String uid;
   private TpPhotoUser tpphotoUser;

   public TpPhotoUser getTpphotoUser() {
      return tpphotoUser;
   }

   public void setTpphotoUser(TpPhotoUser tpphotoUser) {
      this.tpphotoUser = tpphotoUser;
   }

   public int getRid() {
      return rid;
   }

   public void setRid(int rid) {
      this.rid = rid;
   }

   public int getSubtitleId() {
      return subtitleId;
   }

   public void setSubtitleId(int subtitleId) {
      this.subtitleId = subtitleId;
   }

   public String getUid() {
      return uid;
   }

   public void setUid(String uid) {
      this.uid = uid;
   }


}