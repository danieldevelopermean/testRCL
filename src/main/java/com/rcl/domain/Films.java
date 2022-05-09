package com.rcl.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Films {

    public int count;
    public Object next;
    public Object previous;
    public ArrayList<Result> results;

}
