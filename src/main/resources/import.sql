insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Obsidian Son', 'Nate Temple', 1);
insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Blood Debts', 'Nate Temple', 1);
insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Grimm', 'Nate Temple', 1);
insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Midnight Curse', 'Disrupted Magic', 1);
insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Blood Gamble', 'Disrupted Magic', 1);
insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Once Bitten', 'Shadow Guild: The Rebel Book 1', 0);
insert into book(BOOKID, TITLE, SERIES, READ) values (BOOK_SEQ.nextval, 'Wicked Deal', 'Shadow Guild: The Rebel Book 2', 0);


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

