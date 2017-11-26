package Modelo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.ArrayList;

public class Correo {
    private String hostName = "mail.autismoaraba.org";
    private int port = 25;
    private DefaultAuthenticator df;
    private boolean ssl = false;
    private String from;
    private String subject;
    private String msg;
    private ArrayList<String> to;


    public boolean enviarCorreo(){
        Email email = new SimpleEmail();
        email.setHostName(hostName);
        email.setSmtpPort(port);
        email.setAuthenticator(df);
        email.setSSLOnConnect(ssl);
        try {
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(msg);
            for (String t:to) {
                email.addTo(t);
            }
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Correo() {
    }

    public Correo(String subject, String msg, ArrayList<String> to) throws EmailException {
        df = new  DefaultAuthenticator("soporte@autismoaraba.org", "0ewuyqCn"); //TODO cambiar para varios correos
        this.subject = subject;
        this.msg = msg;
        this.to = to;
        this.from = "soporte@autismoaraba.org";
    }

    public DefaultAuthenticator getDf() {
        return df;
    }

    public void setDf(DefaultAuthenticator df) {
        this.df = df;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<String> getTo() {
        return to;
    }

    public void setTo(ArrayList<String> to) {
        this.to = to;
    }

    Email email = new SimpleEmail();

}
