package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class BookVO {
	  //도서 정보
      private Integer bookNo;                 //도서번호
      private String bookName;                //도서이름
      private String bookCoverimg;            //표지
      @DateTimeFormat(pattern = "yy/MM/dd") 
      private Date bookDate;                  //출판일자
      private int bookPrice;                  //금액
      private String bookPublisher;           //출판사
      private String bookInfo;                //도서소개
      //도서 대여 정보
      private int bookCount;
      private int rentPrice;
      
      
}
