package com.ssafy.ssafitlog.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	public int sendEmail(String email) {

		// 0. 수신자 설정
		// 랜덤 변수를 만들어서 발생시키고 싶다면 생성하고 반환한다
		String recipient = email;
		String code = "abc";
		int randomCode = (int) ((Math.random() + 1) * 100000); // 랜덤 여섯자리 숫자

		// 1. 발신자의 메일 계정과 비밀번호 설정
		final String user = "onerosen@naver.com";
		// ** 로 되어있지만 발신 계정의 비밀번호를 적어주시면 됩니다
		final String password = "wkdalse64@";

		// 2. Property에 SMTP 서버 정보 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com");
		// 발신자 메일이 naver이기 때문에 smtp.naver.com 작성
		// gmail이라면 smtp.gmail.com
		prop.put("mail.smtp.port", 587); // 발신자 메일이 네이버일때 587 구글 465
		prop.put("mail.smtp.auth", "true");
		// 발신자 메일이 네이버일때는 아래 두 줄을 포함시키면 안된다
		// 발신자 메일이 구글일때는 아래 두 줄을 포함시켜야한다!
		// prop.put("mail.smtp.ssl.enable", "true");
		// prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		// 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
		// 이 Session은 우리가 사용하던 HttpSession과는 다른 javax.mail 에서 생성하는 session입니다
		// 클래스 이름이 같은 여러 개의 클래스들이 있을 수 있으니
		// 자동 임포트보다는 일일히 하나씩 보면서 javax.mail로 시작하는 클래스를 임포트해주세요
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
		// 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));

			// 수신자 메일 주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// Subject(제목)
			message.setSubject("SSAFY 9기 5반입니다..");

			// Text(본문)
			// 아까 만들어준 랜덤 6자리 숫자를 보내봤습니다
			message.setText("사실 코드 테스트용 메일이지롱~ : " + randomCode);

			Transport.send(message); // send message

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return randomCode;

	}

}
