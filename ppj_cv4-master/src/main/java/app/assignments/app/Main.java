package app.assignments.app;

import app.assignments.Configuration.Config;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Configuration
public class Main {




    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Message ping = (Message) applicationContext.getBean("pingMessage");
        Message hello = (Message) applicationContext.getBean("helloMessage");
        Message pingReply = (Message) applicationContext.getBean("pingMessageReply");

        Writer stdoutWriter = (Writer) applicationContext.getBean("stdoutWriter");
        Writer listWriter = (Writer) applicationContext.getBean("listWriter");
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);


        listWriter.write(ping);
        ((ListWriter) listWriter).listWrittenMessages().forEach(stdoutWriter::write);

    }

}
