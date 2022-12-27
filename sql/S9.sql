DROP TABLE PocketList;
DROP TABLE  PRODUCT;
DROP TABLE  MEMBER;

CREATE TABLE MEMBER (
	ID	VARCHAR2(30)	NOT NULL ,
	PASSWD	VARCHAR2(30)	NOT NULL	 ,
	NAME	VARCHAR2(20)	NOT NULL	 ,
	TEL	NUMBER	NOT NULL	 ,
	BRITHDAY NUMBER	NOT NULL	,
	GENDER	CHAR(1)	NOT NULL
);



CREATE TABLE PRODUCT (
	Pocket	NUMBER	NULL,
	goodsname	VARCHAR(100)	NULL,
	price	NUMBER	NULL,
    productimg	VARCHAR(200)	NULL
);



CREATE TABLE PocketList (
	ID	VARCHAR2(30)	NOT NULL,
	Pocket	NUMBER	NULL,
    times	DATE	NULL
);

ALTER TABLE MEMBER ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	ID
);

ALTER TABLE PRODUCT ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (
	Pocket
);

ALTER TABLE PocketList ADD CONSTRAINT PK_POCKETLIST PRIMARY KEY (
	ID,
	Pocket
);

ALTER TABLE PocketList ADD CONSTRAINT FK_MEMBER_TO_PocketList_1 FOREIGN KEY (
	ID
)
REFERENCES MEMBER (
	ID
);

ALTER TABLE PocketList ADD CONSTRAINT FK_PRODUCT_TO_PocketList_1 FOREIGN KEY (
	Pocket
)
REFERENCES PRODUCT (
	Pocket
);

insert into member values('user1', 'user1', '성철', 1234, 980415, 'M');
insert into member values('user2', 'user2', '하하', 1234, 980416, 'W');
insert into product (POCKET, GOODSNAME, PRICE, PRODUCTIMG) 
            values((Select nvl(max(pocket),0)+1 from PRODUCT), '삼성 노트북 갤럭시북(H) 15인치 i5 11세대 윈도우 10 Pro (NT761XDA-KR58D)',20000, 'https://contents.sixshop.com/thumbnails/uploadedFiles/16843/product/image_1664161070544_1000.png' );
insert into product (POCKET, GOODSNAME, PRICE, PRODUCTIMG) 
             values((Select nvl(max(pocket),0)+1 from PRODUCT), '아이패드 10세대 Wi-Fi 64GB 블루(MPQ13KH/A',38200, 'https://contents.sixshop.com/thumbnails/uploadedFiles/16843/product/image_1669015161739_1000.jpg' );
insert into product (POCKET, GOODSNAME, PRICE, PRODUCTIMG) 
             values((Select nvl(max(pocket),0)+1 from PRODUCT), '애플워치 SE GPS 40mm 실버 알루미늄 케이스, 화이트 스포츠밴드 (MNJV3KH/A)',20200, 'https://contents.sixshop.com/thumbnails/uploadedFiles/16843/product/image_1666784333665_1000.jpg' );
insert into product (POCKET, GOODSNAME, PRICE, PRODUCTIMG) 
             values((Select nvl(max(pocket),0)+1 from PRODUCT), '벤큐 게이밍 모니터 24.5인치 (XL2546K)',39400, 'https://contents.sixshop.com/thumbnails/uploadedFiles/16843/product/image_1647255441491_1000.png' );
insert into product (POCKET, GOODSNAME, PRICE, PRODUCTIMG) 
             values((Select nvl(max(pocket),0)+1 from PRODUCT), '에어팟 프로 2세대 (MQD83KH/A)',20200, 'https://contents.sixshop.com/thumbnails/uploadedFiles/16843/product/image_1666783190556_1000.jpg' );


commit;
desc member;