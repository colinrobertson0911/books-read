insert into book(BOOKID, TITLE, SERIES, DATEREAD, READ) values (BOOK_SEQ.nextval, 'Obsidian Son', 'Nate Temple', TO_DATE('2018/01/03', 'yyyy/MM/dd'), 1);
insert into book(BOOKID, TITLE, SERIES, DATEREAD, READ) values (BOOK_SEQ.nextval, 'Blood Debts', 'Nate Temple', TO_DATE('2018/01/10', 'yyyy/MM/dd'), 1);
insert into book(BOOKID, TITLE, SERIES, DATEREAD, READ) values (BOOK_SEQ.nextval, 'Grimm', 'Nate Temple', TO_DATE('2018/01/15', 'yyyy/MM/dd'), 1);
insert into book(BOOKID, TITLE, SERIES, DATEREAD, READ) values (BOOK_SEQ.nextval, 'Midnight Curse', 'Disrupted Magic', TO_DATE('2018/03/19', 'yyyy/MM/dd'), 1);
insert into book(BOOKID, TITLE, SERIES, DATEREAD, READ) values (BOOK_SEQ.nextval, 'Blood Gamble', 'Disrupted Magic', TO_DATE('2018/03/25', 'yyyy/MM/dd'), 1);

insert into author(AUTHORID, NAME) values (AUTHOR_SEQ.nextval, 'Shayne Silvers');
insert into author(AUTHORID, NAME) values (AUTHOR_SEQ.nextval, 'Melissa F. Olsen');

insert into book_author(BOOKID, AUTHORID) values (1,1);
insert into book_author(BOOKID, AUTHORID) values (2,1);
insert into book_author(BOOKID, AUTHORID) values (3,1);
insert into book_author(BOOKID, AUTHORID) values (4,2);
insert into book_author(BOOKID, AUTHORID) values (5,2);
