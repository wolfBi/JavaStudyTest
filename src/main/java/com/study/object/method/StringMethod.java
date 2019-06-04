package com.study.object.method;

public class StringMethod {
    public static void main(String[] args) {
        String dna = "TTTTT";
        char[] dnaNext = dna.toCharArray();
        char[] dnaThis = new char[dnaNext.length];
        for(int i = 0 ; i < dnaNext.length ; i++){
            switch (dnaNext[i]){
                case  'T':
                    dnaThis[i] = 'A';
                    break;
                case  'A':
                    dnaThis[i] = 'T';
                    break;
                case  'C':
                    dnaThis[i] = 'G';
                    break;
                case  'G':
                    dnaThis[i] = 'C';
                    break;
                default:
                    dnaThis[i] = dnaNext[i];
            }
        }
        System.out.println("args = [" + new String(dnaThis) + "]"); ;
    }
}
