insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Obsidian Son', 'Nate Temple', 1, 'B009NNHPIA', TO_DATE('2017/10/14', 'yyyy/MM/dd'), TO_DATE('2012/10/08', 'yyyy/MM/dd'));
insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Blood Debts', 'Nate Temple', 1, 'B0180YBIYY', TO_DATE('2018/02/08', 'yyyy/MM/dd'), TO_DATE('2015/11/14', 'yyyy/MM/dd'));
insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Grimm', 'Nate Temple', 1, 'B01L1CM1T8', TO_DATE('2018/02/13', 'yyyy/MM/dd'), TO_DATE('2012/10/08', 'yyyy/MM/dd'));
insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Midnight Curse', 'Disrupted Magic', 1, 'B01JGIOO3A', TO_DATE('2018/03/19', 'yyyy/MM/dd'), TO_DATE('2017/02/07', 'yyyy/MM/dd'));
insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Blood Gamble', 'Disrupted Magic', 1, 'B01N3B1BPW', TO_DATE('2018/03/25', 'yyyy/MM/dd'), TO_DATE('2017/07/25', 'yyyy/MM/dd'));
insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Once Bitten', 'Shadow Guild: The Rebel Book 1', 0, 'B087JVF3HG', TO_DATE(null), TO_DATE('2020/04/29', 'yyyy/MM/dd'));
insert into book(BOOKID, TITLE, SERIES, READ, ASIN, DATEREAD, PUBLISHEDDATE) values (BOOK_SEQ.nextval, 'Wicked Deal', 'Shadow Guild: The Rebel Book 2', 0, 'B0881WVVLH', TO_DATE(null), TO_DATE('2020/05/25', 'yyyy/MM/dd'));


insert into author(AUTHORID, FULLNAME) values (AUTHOR_SEQ.nextval, 'Shayne Silvers');
insert into author(AUTHORID, FULLNAME) values (AUTHOR_SEQ.nextval, 'Melissa F. Olsen');
insert into author(AUTHORID, FULLNAME) values (AUTHOR_SEQ.nextval, 'Linsey Hall');


insert into book_author(BOOKID, AUTHORID) values (1,1);
insert into book_author(BOOKID, AUTHORID) values (2,1);
insert into book_author(BOOKID, AUTHORID) values (3,1);
insert into book_author(BOOKID, AUTHORID) values (4,2);
insert into book_author(BOOKID, AUTHORID) values (5,2);
insert into book_author(BOOKID, AUTHORID) values (6,3);
insert into book_author(BOOKID, AUTHORID) values (7,3);

