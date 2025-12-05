package org.example.expert.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Aspect
@RequiredArgsConstructor
@Component
public class AdminLogAspect {

    private final ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(AdminLogAspect.class);

    @Pointcut("execution(* org.example.expert.domain.user.controller.UserAdminController.*(..))")
    public void userAdminController() {
    }

    @Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.*(..))")
    public void userAdminComment() {
    }

    @Around("userAdminController() || userAdminComment()")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("userAdminController");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Object userId = request.getAttribute("userId");
        String requestURI = request.getRequestURI();
        LocalDateTime now = LocalDateTime.now();
        Object[] args = joinPoint.getArgs();

        log.info("========== [ADMIN API BEFORE] ==========");
        log.info("사용자의 ID    : {}", userId);
        log.info("API 요청 URL  : {}", requestURI);
        log.info("API 요청 시각  : {}", now);

        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        for (Object arg : args) {
            log.info("요청 본문  : {}", om.writeValueAsString(arg));
        }

        Object proceed = joinPoint.proceed();

        String responseBody = objectMapper.writeValueAsString(proceed);

        log.info("========== [ADMIN API AFTER] ==========");
            log.info("Response Body : {}", responseBody);
        }
    }
