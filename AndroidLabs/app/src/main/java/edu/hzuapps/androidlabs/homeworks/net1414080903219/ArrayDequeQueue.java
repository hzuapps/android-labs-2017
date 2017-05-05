package homeworks.androids.hzuapps.edu.application.net1414080903219;

import java.util.ArrayDeque;

/**
 * Created by mary on 2017/5/4.
 */

import java.util.ArrayDeque;

public class ArrayDequeQueue {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayDeque<Word> queue=new ArrayDeque<Word>();
        queue.add(new Word("audience", "n.观众", "未学"));
        queue.add(new Word("background", "n.背景", "未学"));
        queue.add(new Word("challenge", "n,挑战;向...挑战", "未学"));
        queue.add(new Word("descend", "v,下降", "未学"));
        queue.add(new Word("elite", "n,精英,掌权人物", "未学"));
        queue.add(new Word("faculty", "n,能力,才能", "未学"));
        queue.add(new Word("grope", "v,摸索", "未学"));
        queue.add(new Word("hysterical", "adj,歇斯底里的,情绪激动的", "未学"));
        queue.add(new Word("infant", "n,婴儿;adj,婴儿的", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
        queue.add(new Word("", "", "未学"));
    }

}
class Word{
    String word;
    String mean;
    String status;
    public Word(String en,String ch,String state) {
        this.word=word;
        this.mean=mean;
        this.status=status;
    }
}
