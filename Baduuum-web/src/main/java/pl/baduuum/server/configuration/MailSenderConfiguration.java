package pl.baduuum.server.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "pl.baduuum.server.configuration" })
@PropertySource(value = {"classpath:mail_configuration.properties"})
public class MailSenderConfiguration {
	
	@Autowired
    private Environment environment;
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("Messages"); ;
		return messageSource;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760); // 10MB
		return multipartResolver;
	}
	
	@Bean
	public JavaMailSenderImpl mailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(environment.getRequiredProperty("mail.server.host"));
		mailSender.setPort(Integer.parseInt(environment.getRequiredProperty("mail.server.port")));
		mailSender.setProtocol(environment.getRequiredProperty("mail.server.protocol"));
		mailSender.setUsername(environment.getRequiredProperty("mail.server.username"));
		mailSender.setPassword(environment.getRequiredProperty("mail.server.password"));
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", Boolean.parseBoolean(environment.getRequiredProperty("mail.smtp.auth")));
	    mailProperties.put("mail.smtp.starttls.enable", Boolean.parseBoolean(environment.getRequiredProperty("mail.smtp.starttls.enable")));
		mailProperties.put("mail.smtp.ssl.enable", Boolean.parseBoolean(environment.getRequiredProperty("mail.smtp.ssl.enable")));
		mailSender.setJavaMailProperties(mailProperties);
		return mailSender;
	}
	
	@Bean
	public ClassLoaderTemplateResolver emailTemplateResolver() {
		ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
		emailTemplateResolver.setPrefix("mail/");
		emailTemplateResolver.setTemplateMode("HTML5");
		emailTemplateResolver.setCharacterEncoding("UTF-8");
		emailTemplateResolver.setOrder(1);
		emailTemplateResolver.setCacheable(true);		
		return emailTemplateResolver;
	}
	
	@Bean 
	public ServletContextTemplateResolver webTemplateResolver() {
		ServletContextTemplateResolver webTemplateResolver = new ServletContextTemplateResolver();
		webTemplateResolver.setPrefix("/WEB-INF/templates/");
		webTemplateResolver.setTemplateMode("HTML5");
		webTemplateResolver.setCharacterEncoding("UTF-8");
		webTemplateResolver.setOrder(1);
		webTemplateResolver.setCacheable(true);	
		return webTemplateResolver;
	}
	
	@Bean 
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.addTemplateResolver(emailTemplateResolver());
		templateEngine.addTemplateResolver(webTemplateResolver());
		return templateEngine;
	}
	
	@Bean ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}

}
