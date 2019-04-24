package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.print("执行HelloAction.....");
        return NONE;
    }
}