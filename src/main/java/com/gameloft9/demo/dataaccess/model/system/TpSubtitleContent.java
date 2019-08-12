package com.gameloft9.demo.dataaccess.model.system;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TpSubtitleContent implements Serializable {
  private int subtitleId;
  private int bigTitleId;
  private String subtitleContent;
  private List<TpStandard> bz_coll ;
  private List<Tprelationship> beice;


  public int getSubtitleId() {
    return subtitleId;
  }

  public void setSubtitleId(int subtitleId) {
    this.subtitleId = subtitleId;
  }
}