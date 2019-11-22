package com.xqd.javatest.builderpattern;

/**
 * Created by 谢邱东 on 2019/11/22 10:27.
 * NO bug
 */

class TextBuilder extends Builder {

    StringBuffer mBuffer=new StringBuffer();

    @Override
    public void makeTitle(String title) {
          mBuffer.append("=========================");
        mBuffer.append("\n");
          mBuffer.append("     【 "+title+" 】");
          mBuffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        mBuffer.append(">> "+str);
        mBuffer.append("\n");

    }

    @Override
    public void makeItems(String[] items) {
        for(String s:items){
            mBuffer.append(" ."+s+"\n");
        }
        mBuffer.append("\n");
    }

    @Override
    public void close() {
        mBuffer.append("=========================");
    }

    public String getResult(){
        return mBuffer.toString();
    }
}
