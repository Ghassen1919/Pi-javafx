package services;

/**
 *
 * @author sarawahada
 */


import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.HTMLEditor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;



public class SendingMail 
{
    

    public static void send(String recepient,int mot) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="eSportsappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessage(session,myAccountEmail,recepient,mot);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessage(Session session,String myAccountEmail,String recepient,int mot) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("password reset");
            message.setText(mot+" your verification code");
            return message;
    }
        public static void sendSignUp(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessageSignUp(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageSignUp(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account created");
            String htmlCode="<!DOCTYPE html>\n" +
"                            <html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"                            \n" +
"                            <head>\n" +
"                            \\t<title></title>\n" +
"                            \\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"                            \\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"                            \\t<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"                            \\t<!--[if !mso]><!-->\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Chivo\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<!--<![endif]-->\n" +
"                            \\t<style>\n" +
"                            \\t\\t* {\n" +
"                            \\t\\t\\tbox-sizing: border-box;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\tbody {\n" +
"                            \\t\\t\\tmargin: 0;\n" +
"                            \\t\\t\\tpadding: 0;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\ta[x-apple-data-detectors] {\n" +
"                            \\t\\t\\tcolor: inherit !important;\n" +
"                            \\t\\t\\ttext-decoration: inherit !important;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\t#MessageViewBody a {\n" +
"                            \\t\\t\\tcolor: inherit;\n" +
"                            \\t\\t\\ttext-decoration: none;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\tp {\n" +
"                            \\t\\t\\tline-height: inherit\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\t@media (max-width:720px) {\n" +
"                            \\t\\t\\t.row-content {\n" +
"                            \\t\\t\\t\\twidth: 100% !important;\n" +
"                            \\t\\t\\t}\n" +
"                            \n" +
"                            \\t\\t\\t.column .border {\n" +
"                            \\t\\t\\t\\tdisplay: none;\n" +
"                            \\t\\t\\t}\n" +
"                            \n" +
"                            \\t\\t\\t.stack .column {\n" +
"                            \\t\\t\\t\\twidth: 100%;\n" +
"                            \\t\\t\\t\\tdisplay: block;\n" +
"                            \\t\\t\\t}\n" +
"                            \\t\\t}\n" +
"                            \\t</style>\n" +
"                            </head>\n" +
"                            \n" +
"                            <body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"                            \\t<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\">\n" +
"                            \\t\\t<tbody>\n" +
"                            \\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/bg_hero_illo.jpg'); background-repeat: repeat;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 60px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png\" style=\"display: block; height: auto; border: 0; width: 140px; max-width: 100%;\" width=\"140\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:35px;padding-left:10px;padding-right:10px;padding-top:10px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: 'Chivo', Arial, Helvetica, sans-serif; font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; text-align: center; font-size: 12px;\"><span style=\"color:#ffcc00;\"><span style=\"font-size:38px;\"><em>Congrats on joining EFood!</em></span></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/illo_hero_transparent.png\" style=\"display: block; height: auto; border: 0; width: 587px; max-width: 100%;\" width=\"587\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;\"><span style=\"font-size:18px;\">Hi there!</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;\"><span style=\"font-size:18px;\">Thanks for joining us !</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;\"><span style=\"font-size:18px;\">Let's introduce you to some of our best features.</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/sayagata-400px.png'); background-repeat: repeat;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"33.333333333333336%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:70px;padding-left:40px;padding-right:40px;padding-top:70px;width:100%;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/iphone_v1_1png.png\" style=\"display: block; height: auto; border: 0; width: 117px; max-width: 100%;\" width=\"117\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-2\" width=\"66.66666666666667%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:10px;padding-right:40px;padding-top:65px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px;\"><span style=\"font-size:22px;\"><strong>Feature 1<br></strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:5px;padding-left:10px;padding-right:40px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px;\"><span style=\"font-size:16px;color:#ffcc00;\"><strong>Rapidity</strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:10px;padding-right:40px;padding-bottom:30px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 24px;\"><span style=\"font-size:16px;\">Unlike many other food delivering apps we guarantee rapidity and quality!</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"66.66666666666667%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:40px;padding-top:65px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 18px; color: #5beda6; line-height: 1.5;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: right; mso-line-height-alt: 33px;\"><span style=\"font-size:22px;\"><strong>Feature 2<br></strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:5px;padding-left:40px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: right;\"><span style=\"font-size:16px;color:#ffcc00;\"><strong>Green</strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:40px;padding-bottom:30px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: right; mso-line-height-alt: 24px;\"><span style=\"font-size:16px;\">Our vast food choices include vegan and vegetarian options for our Green clients.</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-2\" width=\"33.333333333333336%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:70px;padding-left:40px;padding-right:40px;padding-top:70px;width:100%;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/iphone_v1_2.png\" style=\"display: block; height: auto; border: 0; width: 117px; max-width: 100%;\" width=\"117\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-5\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/sayagata-400px.png'); background-repeat: repeat;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"33.333333333333336%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:70px;padding-left:40px;padding-right:40px;padding-top:70px;width:100%;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/iphone_v1_3.png\" style=\"display: block; height: auto; border: 0; width: 117px; max-width: 100%;\" width=\"117\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-2\" width=\"66.66666666666667%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:10px;padding-right:40px;padding-top:65px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px;\"><span style=\"font-size:22px;\"><strong>Feature 3<br></strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:5px;padding-left:10px;padding-right:40px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px;\"><span style=\"font-size:16px;color:#ffcc00;\"><strong>Sales</strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:10px;padding-right:40px;padding-bottom:30px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 24px;\"><span style=\"font-size:16px;\">We offer regular sales and discount codes for our loyal clients.</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-6\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #9ef2c3;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-right:20px;width:100%;padding-left:0px;padding-top:5px;padding-bottom:45px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"right\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/gplay.gif\" style=\"display: block; height: auto; border: 0; width: 122px; max-width: 100%;\" width=\"122\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:20px;width:100%;padding-right:0px;padding-top:5px;padding-bottom:5px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/appstore.png\" style=\"display: block; height: auto; border: 0; width: 122px; max-width: 100%;\" width=\"122\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-7\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 40px; padding-bottom: 40px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:15px;width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png\" style=\"display: block; height: auto; border: 0; width: 148px; max-width: 100%;\" width=\"148\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:16px;\"><strong>EFood Delivery</strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 14.399999999999999px;\">&nbsp;</p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"social_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"social-table\" width=\"148px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" align=\"center\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://twitter.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/twitter@2x.png\" width=\"32\" height=\"32\" alt=\"Twitter\" title=\"Twitter\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://plus.google.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/googleplus@2x.png\" width=\"32\" height=\"32\" alt=\"Google+\" title=\"Google+\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://www.youtube.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/youtube@2x.png\" width=\"32\" height=\"32\" alt=\"YouTube\" title=\"YouTube\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/facebook@2x.png\" width=\"32\" height=\"32\" alt=\"Facebook\" title=\"Facebook\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-8\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #555555; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 12px; text-align: center;\">All rights reserved \\u00a9 2018 /&nbsp; Efood</p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t</tr>\n" +
"                            \\t\\t</tbody>\n" +
"                            \\t</table><!-- End -->\n" +
"                            </body>\n" +
"                            \n" +
"                            </html>";
                            
            message.setContent(htmlCode ,"text/html");
            return message;
    }
         public static void sendPasswordReset(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessagePasswordReset(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }
    private static Message prepareMessagePasswordReset(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Password reset");
            String htmlCode="<!DOCTYPE html>\n" +
"                            <html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"                            \n" +
"                            <head>\n" +
"                            \\t<title></title>\n" +
"                            \\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"                            \\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"                            \\t<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"                            \\t<!--[if !mso]><!-->\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Bitter\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Cormorant+Garamond\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Cabin\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Droid+Serif\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<!--<![endif]-->\n" +
"                            \\t<style>\n" +
"                            \\t\\t* {\n" +
"                            \\t\\t\\tbox-sizing: border-box;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\tbody {\n" +
"                            \\t\\t\\tmargin: 0;\n" +
"                            \\t\\t\\tpadding: 0;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\ta[x-apple-data-detectors] {\n" +
"                            \\t\\t\\tcolor: inherit !important;\n" +
"                            \\t\\t\\ttext-decoration: inherit !important;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\t#MessageViewBody a {\n" +
"                            \\t\\t\\tcolor: inherit;\n" +
"                            \\t\\t\\ttext-decoration: none;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\tp {\n" +
"                            \\t\\t\\tline-height: inherit\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\t@media (max-width:670px) {\n" +
"                            \\t\\t\\t.row-content {\n" +
"                            \\t\\t\\t\\twidth: 100% !important;\n" +
"                            \\t\\t\\t}\n" +
"                            \n" +
"                            \\t\\t\\t.column .border {\n" +
"                            \\t\\t\\t\\tdisplay: none;\n" +
"                            \\t\\t\\t}\n" +
"                            \n" +
"                            \\t\\t\\t.stack .column {\n" +
"                            \\t\\t\\t\\twidth: 100%;\n" +
"                            \\t\\t\\t\\tdisplay: block;\n" +
"                            \\t\\t\\t}\n" +
"                            \\t\\t}\n" +
"                            \\t</style>\n" +
"                            </head>\n" +
"                            \n" +
"                            <body style=\"background-color: #85a4cd; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"                            \\t<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #85a4cd;\">\n" +
"                            \\t\\t<tbody>\n" +
"                            \\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 650px;\" width=\"650\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:10px;text-align:center;width:100%;padding-top:60px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: 'Roboto Slab', Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 30px; font-weight: 400; letter-spacing: 2px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong>Your password has been reset!</strong></h1>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3856/GIF_password.gif\" style=\"display: block; height: auto; border: 0; width: 500px; max-width: 100%;\" width=\"500\" alt=\"Wrong Password Animation\" title=\"Wrong Password Animation\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:5px;padding-left:10px;padding-right:10px;padding-top:25px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:20px;\">Don't worry! Your account has been restored!</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:5px;padding-left:10px;padding-right:10px;padding-top:5px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:22px;\">Use your new password to login.</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:40px;padding-left:10px;padding-right:10px;padding-top:50px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:14px;\">If you didn\\u2019t request to change your password, Let us know.</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #c4d6ec;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 650px;\" width=\"650\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 20px; padding-bottom: 20px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:12px;\">If you continue to have problems</span><br><span style=\"font-size:12px;\">please feel free to contact us .<a href=\"https://www.example.com\" target=\"_blank\" style=\"text-decoration: underline; color: #ffffff;\" rel=\"noopener\"></a></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f6fe;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 650px;\" width=\"650\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"social_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:40px;padding-left:20px;padding-right:20px;padding-top:50px;text-align:center;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"social-table\" width=\"208px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" align=\"center\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/facebook@2x.png\" width=\"32\" height=\"32\" alt=\"Facebook\" title=\"facebook\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/twitter@2x.png\" width=\"32\" height=\"32\" alt=\"Twitter\" title=\"twitter\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/linkedin@2x.png\" width=\"32\" height=\"32\" alt=\"Linkedin\" title=\"linkedin\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/instagram@2x.png\" width=\"32\" height=\"32\" alt=\"Instagram\" title=\"instagram\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t</tr>\n" +
"                            \\t\\t</tbody>\n" +
"                            \\t</table><!-- End -->\n" +
"                            </body>\n" +
"                            \n" +
"                            </html>";
                           
            message.setContent(htmlCode ,"text/html");
            return message;
    }
            public static void sendAccountModified(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessageAccountModified(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }
    private static Message prepareMessageAccountModified(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account modified ");
            String htmlCode="<!DOCTYPE html>\n" +
"                            <html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"                            \n" +
"                            <head>\n" +
"                            \\t<title></title>\n" +
"                            \\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"                            \\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"                            \\t<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"                            \\t<!--[if !mso]><!-->\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Chivo\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n" +
"                            \\t<!--<![endif]-->\n" +
"                            \\t<style>\n" +
"                            \\t\\t* {\n" +
"                            \\t\\t\\tbox-sizing: border-box;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\tbody {\n" +
"                            \\t\\t\\tmargin: 0;\n" +
"                            \\t\\t\\tpadding: 0;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\ta[x-apple-data-detectors] {\n" +
"                            \\t\\t\\tcolor: inherit !important;\n" +
"                            \\t\\t\\ttext-decoration: inherit !important;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\t#MessageViewBody a {\n" +
"                            \\t\\t\\tcolor: inherit;\n" +
"                            \\t\\t\\ttext-decoration: none;\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\tp {\n" +
"                            \\t\\t\\tline-height: inherit\n" +
"                            \\t\\t}\n" +
"                            \n" +
"                            \\t\\t@media (max-width:720px) {\n" +
"                            \\t\\t\\t.row-content {\n" +
"                            \\t\\t\\t\\twidth: 100% !important;\n" +
"                            \\t\\t\\t}\n" +
"                            \n" +
"                            \\t\\t\\t.column .border {\n" +
"                            \\t\\t\\t\\tdisplay: none;\n" +
"                            \\t\\t\\t}\n" +
"                            \n" +
"                            \\t\\t\\t.stack .column {\n" +
"                            \\t\\t\\t\\twidth: 100%;\n" +
"                            \\t\\t\\t\\tdisplay: block;\n" +
"                            \\t\\t\\t}\n" +
"                            \\t\\t}\n" +
"                            \\t</style>\n" +
"                            </head>\n" +
"                            \n" +
"                            <body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"                            \\t<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\">\n" +
"                            \\t\\t<tbody>\n" +
"                            \\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/bg_hero_illo.jpg'); background-repeat: repeat;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 60px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png\" style=\"display: block; height: auto; border: 0; width: 140px; max-width: 100%;\" width=\"140\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:35px;padding-left:10px;padding-right:10px;padding-top:10px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Arial, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: 'Chivo', Arial, Helvetica, sans-serif; font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; text-align: center; font-size: 12px;\"><span style=\"color:#ffcc00;\"><span style=\"font-size:38px;\"><em>Your profile was updated successfully!</em></span></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/illo_hero_transparent.png\" style=\"display: block; height: auto; border: 0; width: 587px; max-width: 100%;\" width=\"587\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;\"><span style=\"font-size:18px;\">Hi there!</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;\"><span style=\"font-size:18px;\">We want to let you know that your profile has been updated successfully.</span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"divider_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 1px solid #BBBBBB;\"><span>&#8202;</span></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 14px; mso-line-height-alt: 21px; color: #393d47; line-height: 1.5; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><strong><span style=\"font-size:16px;\">If it wasn't you who updated the profile, Let us know.</span></strong></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #9ef2c3;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-right:20px;width:100%;padding-left:0px;padding-top:5px;padding-bottom:45px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"right\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/gplay.gif\" style=\"display: block; height: auto; border: 0; width: 122px; max-width: 100%;\" width=\"122\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-left:20px;width:100%;padding-right:0px;padding-top:5px;padding-bottom:5px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/appstore.png\" style=\"display: block; height: auto; border: 0; width: 122px; max-width: 100%;\" width=\"122\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 40px; padding-bottom: 40px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding-bottom:15px;width:100%;padding-right:0px;padding-left:0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png\" style=\"display: block; height: auto; border: 0; width: 148px; max-width: 100%;\" width=\"148\" alt=\"Image\" title=\"Image\"></div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:16px;\"><strong>EFood Delivery</strong></span></p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 14.399999999999999px;\">&nbsp;</p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"social_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"social-table\" width=\"148px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" align=\"center\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://twitter.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/twitter@2x.png\" width=\"32\" height=\"32\" alt=\"Twitter\" title=\"Twitter\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://plus.google.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/googleplus@2x.png\" width=\"32\" height=\"32\" alt=\"Google+\" title=\"Google+\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://www.youtube.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/youtube@2x.png\" width=\"32\" height=\"32\" alt=\"YouTube\" title=\"YouTube\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td style=\"padding:0 5px 0 0px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/facebook@2x.png\" width=\"32\" height=\"32\" alt=\"Facebook\" title=\"Facebook\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t<table class=\"row row-5\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4;\">\n" +
"                            \\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;\" width=\"700\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-family: sans-serif\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<div style=\"font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #555555; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t<p style=\"margin: 0; font-size: 12px; text-align: center;\">All rights reserved \\u00a9 2022 /&nbsp; Efood</p>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</div>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t\\t\\t\\t\\t</tr>\n" +
"                            \\t\\t\\t\\t\\t\\t</tbody>\n" +
"                            \\t\\t\\t\\t\\t</table>\n" +
"                            \\t\\t\\t\\t</td>\n" +
"                            \\t\\t\\t</tr>\n" +
"                            \\t\\t</tbody>\n" +
"                            \\t</table><!-- End -->\n" +
"                            </body>\n" +
"                            </html>\"";
                
            message.setContent(htmlCode ,"text/html");
            return message;
    }
     public static void sendBanned(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessageBanned(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }
    private static Message prepareMessageBanned(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Banned");
            String htmlCode="<!DOCTYPE html>\n" +
"<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"\n" +
"<head>\n" +
"	<title></title>\n" +
"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"	<!--[if !mso]><!-->\n" +
"	<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"https://fonts.googleapis.com/css2?family=Alex+Brush&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<!--<![endif]-->\n" +
"	<style>\n" +
"		* {\n" +
"			box-sizing: border-box;\n" +
"		}\n" +
"\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: inherit !important;\n" +
"		}\n" +
"\n" +
"		#MessageViewBody a {\n" +
"			color: inherit;\n" +
"			text-decoration: none;\n" +
"		}\n" +
"\n" +
"		p {\n" +
"			line-height: inherit\n" +
"		}\n" +
"\n" +
"		@media (max-width:700px) {\n" +
"			.row-content {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.column .border {\n" +
"				display: none;\n" +
"			}\n" +
"\n" +
"			.stack .column {\n" +
"				width: 100%;\n" +
"				display: block;\n" +
"			}\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"\n" +
"<body style=\"background-color: #f2f2f2; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f2f2f2;\">\n" +
"		<tbody>\n" +
"			<tr>\n" +
"				<td>\n" +
"					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block\" style=\"height:40px;line-height:40px;font-size:1px;\">&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3951/header_bg.png'); background-position: top center; background-repeat: no-repeat;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:15px;padding-left:20px;padding-right:20px;padding-top:125px;\">\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 30px;\"><strong>Unfortunately, </strong></p>\n" +
"																		<p style=\"margin: 0; font-size: 30px;\"><strong>You have been banned from using the app.</strong></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"text-align:center;width:100%;padding-top:45px;\">\n" +
"																<h1 style=\"margin: 0; color: #000000; direction: ltr; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; font-size: 16px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span style=\"color: #000000;\"><a href=\"http://www.example.com\" target=\"_blank\" style=\"text-decoration: none; color: #000000;\" rel=\"noopener\"><strong>Contact us&gt;&gt;</strong></a></span></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:45px;padding-bottom:25px;\">\n" +
"																<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3951/buyer_1.png\" style=\"display: block; height: auto; border: 0; width: 301px; max-width: 100%;\" width=\"301\" alt=\"buyer\" title=\"buyer\"></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #7ecd34; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"20\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:16px;\"><strong>If you think we made a mistake, reach out to us!</strong></span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:20px;padding-right:20px;padding-top:30px;\">\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:30px;\"><strong><span style>Trouble reaching your account ? We're here to help!</span></strong></span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"button_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:30px;text-align:center;\">\n" +
"																<div align=\"center\">\n" +
"																	<!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"www.example.com\" style=\"height:44px;width:147px;v-text-anchor:middle;\" arcsize=\"46%\" strokeweight=\"0.75pt\" strokecolor=\"#60BB44\" fillcolor=\"#60bb44\"><w:anchorlock/><v:textbox inset=\"0px,0px,0px,0px\"><center style=\"color:#ffffff; font-family:Tahoma, Verdana, sans-serif; font-size:16px\"><![endif]--><a href=\"www.example.com\" target=\"_blank\" style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#60bb44;border-radius:20px;width:auto;border-top:1px solid #60BB44;border-right:1px solid #60BB44;border-bottom:1px solid #60BB44;border-left:1px solid #60BB44;padding-top:5px;padding-bottom:5px;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><span style=\"font-size: 16px; line-height: 32px;\" data-mce-style=\"font-size: 16px; line-height: 32px;\"><strong><span style=\"line-height: 32px;\" data-mce-style=\"line-height: 32px;\">CONTACT US</span></strong></span></span></span></a>\n" +
"																	<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:20px;padding-right:20px;padding-top:30px;\">\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:16px;\"><strong>For any questions, email us or call us Monday to Friday 8:30 AM - 5:30 PM</strong></span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-5\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-position: top center;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"html_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-top:10px;\">\n" +
"																<div style=\"font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;\" align=\"center\"></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 12px; mso-line-height-alt: 21.6px; color: #000000; line-height: 1.8; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"																		<p style=\"margin: 0; text-align: center; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Copyright © 2022, EFood.</span></p>\n" +
"																		<p style=\"margin: 0; text-align: center; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Changed your mind? You can<a href=\"http://www.example.com\" target=\"_blank\" style=\"text-decoration: underline; color: #000000;\" rel=\"noopener\"> unsubscribe</a>&nbsp;at any time.</span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"social_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:30px;padding-left:10px;padding-right:10px;padding-top:10px;text-align:center;\">\n" +
"																<table class=\"social-table\" width=\"144px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" align=\"center\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																	<tr>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/facebook@2x.png\" width=\"32\" height=\"32\" alt=\"Facebook\" title=\"facebook\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/twitter@2x.png\" width=\"32\" height=\"32\" alt=\"Twitter\" title=\"twitter\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/linkedin@2x.png\" width=\"32\" height=\"32\" alt=\"Linkedin\" title=\"linkedin\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/instagram@2x.png\" width=\"32\" height=\"32\" alt=\"Instagram\" title=\"instagram\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-6\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #60bb44; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block\" style=\"height:40px;line-height:40px;font-size:1px;\">&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"				</td>\n" +
"			</tr>\n" +
"		</tbody>\n" +
"	</table><!-- End -->\n" +
"</body>\n" +
"\n" +
"</html>";
            message.setContent(htmlCode ,"text/html");
            return message;
    }
}