package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class PeerReviewList extends DropdownList {

  public PeerReviewList () {
    values = new Vector();
  }

  public void addPeerReview(String code) {
    values.add(new DropdownValue(code));
  }
}