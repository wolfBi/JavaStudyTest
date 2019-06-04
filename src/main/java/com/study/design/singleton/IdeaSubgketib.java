package com.study.design.singleton;

public class IdeaSubgketib {
    private static IdeaSubgketib ourInstance = new IdeaSubgketib();

    public static IdeaSubgketib getInstance() {
        return ourInstance;
    }

    private IdeaSubgketib() {
    }
}
