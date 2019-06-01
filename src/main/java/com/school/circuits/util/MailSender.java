package com.school.circuits.util;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MailSender {

  public MailSender(){}

  public static boolean send(String correo,
                             String nombrecompleto, String asunto, String mensaje){
    try{

      final String username = "vpnismael@gmail.com";
      final String password = "ismael1497";
      Properties mailproperties = new Properties();
      mailproperties.put("mail.smtp.auth", "true");
      mailproperties.put("mail.smtp.starttls.enable", "true");
      mailproperties.put("mail.smtp.host", "smtp.gmail.com");
      mailproperties.put("mail.smtp.port", "587");

      Session mailsession = Session.getInstance(mailproperties,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
          }
        });
     // mailproperties.put("mail.smtp.host", "correo.adm.urbe.edu");
     // Session mailsession = Session.getDefaultInstance(mailproperties, null);

      //Direcciones de correo
      InternetAddress remitente = new InternetAddress (nombrecompleto + " <" + correo + ">");

      String mailAddressTo = "ismaeljpv14@gmail.com";

      InternetAddress mailAddress_TO = new InternetAddress(mailAddressTo);

      Date objfecha = new Date();
      String formatoFecha = "dd/MM/yyyy   hh:mm:ss a ";
      SimpleDateFormat objSDF = new SimpleDateFormat(formatoFecha);
      String fecha = objSDF.format(objfecha);

      //iniciación del objeto mensaje
      Message msj = new MimeMessage(mailsession);
      msj.setFrom(remitente);

      //los posibles tipos son: TO CC BCC
      msj.addRecipient(Message.RecipientType.TO, mailAddress_TO);

      //asunto
      msj.setSubject(asunto);

      // mensaje a enviar y su tipo
      String msg = "Nombre de la persona: "+ nombrecompleto +
        "<br>Correo electrónico: "+correo+
        "<br>Mensaje: "+mensaje+
        "<br>Fecha del registro: "+fecha;

      msj.setContent(msg, "text/html");

      //enviar el mensaje
      javax.mail.Transport.send(msj);
      return true;
    }catch(Exception ex){
      System.out.println(">> MailSender.send() error = "+ex);
      return false;
    }
  }
}
