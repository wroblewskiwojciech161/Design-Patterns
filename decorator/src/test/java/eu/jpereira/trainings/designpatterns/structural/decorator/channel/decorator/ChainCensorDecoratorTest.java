package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ChainCensorDecoratorTest extends AbstractSocialChanneldDecoratorTest {

    // Create the array list of censored words
    private ArrayList<String> censoredWords = new ArrayList<String>(Arrays.asList("Microsoft", "Twitter", "Facebook", "Linkedin", "this"));

    @Test
    public void testChainTwoDecorators() {

        // Create the builder
        SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

        // create a spy social channel
        SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);

        // Chain decorators
        SocialChannel channel = builder.
                with(new MessageTruncator(10)).
                with(new URLAppender("http://jpereira.eu")).
                with(new WordCensor(censoredWords)).
                getDecoratedChannel(props);

        channel.deliverMessage("this is a message");
        // Spy channel. Should get the one created before
        TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);
        assertEquals("**** is... http://jpereira.eu", spyChannel.lastMessagePublished());
    }

    @Test
    public void testChainTwoDecoratorsWithoutBuilder() {

        SocialChannel channel = new TestSpySocialChannel();

        SocialChannel urlAppenderChannel = new URLAppender("http://jpereira.eu", channel);

        //Now create a truncator
        SocialChannel messageTruncatorChannel = new MessageTruncator(10, urlAppenderChannel);

        // Create word censor
        SocialChannel wordCensor = new WordCensor(censoredWords, messageTruncatorChannel);
        wordCensor.deliverMessage("this is a message");
        // Spy channel. Should get the one created before
        TestSpySocialChannel spy = (TestSpySocialChannel)channel;
        assertEquals("**** is... http://jpereira.eu", spy.lastMessagePublished());
    }

    @Test
    public void testOtherChainTwoDecorators() {
        // Create the builder
        SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

        // create a spy social channel
        SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);

        // Chain decorators
        SocialChannel channel = builder.
                with(new URLAppender("http://jpereira.eu")).
                andWith(new MessageTruncator(30)).
                with(new WordCensor(censoredWords)).
                getDecoratedChannel(props);

        channel.deliverMessage("this is a message");
        // Spy channel. Should get the one created before
        TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);
        assertEquals("**** is a message http://jp...", spyChannel.lastMessagePublished());
    }
}