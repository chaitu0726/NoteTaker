-- DB name
use profile;

-- Login Table
create table Login(
	login_id int primary key AUTO_INCREMENT,
    user_id varchar(30),
    passcode varchar(30)
);


-- Note data table
create table NOTE_DATA(
	note_data_id int primary key auto_increment,
    note_title varchar(50),
    note_description varchar(200),
    login_id int,
    FOREIGN KEY (login_id) REFERENCES Login(login_id)
);