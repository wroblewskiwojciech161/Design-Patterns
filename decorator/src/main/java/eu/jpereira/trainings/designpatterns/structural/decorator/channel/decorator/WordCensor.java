package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

import java.util.ArrayList;

public class WordCensor extends SocialChannelDecorator {

    ArrayList<String> censoredWords;

    public WordCensor(ArrayList<String> censoredWords,  SocialChannel channel) {
        this.censoredWords = censoredWords;
        this.delegate = channel;
    }

    public WordCensor(ArrayList<String> censoredWords) {
        this.censoredWords = censoredWords;
    }


    @Override
    public void deliverMessage(String message) {
        String[] messageTab = message.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : messageTab){
            for(String censoredWord : censoredWords){
                if(word.equals(censoredWord)){
                    word = "****";
                    continue;
                }
            }
            stringBuilder.append(word+" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        message = stringBuilder.toString();
        delegate.deliverMessage(message);
    }
}