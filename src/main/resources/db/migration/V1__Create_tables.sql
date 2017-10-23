CREATE TABLE users (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  mail varchar(255) DEFAULT NULL,
  pass varchar(255) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE courts (
  court_id bigint(20) NOT NULL AUTO_INCREMENT,
  court_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (court_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cases (
  case_id bigint(20) NOT NULL AUTO_INCREMENT,
  next_review_date datetime DEFAULT NULL,
  number_case varchar(255) DEFAULT NULL,
  price double NOT NULL,
  state int(11) DEFAULT NULL,
  court_id bigint(20) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (case_id),
  KEY FK_case_court_id (court_id),
  KEY FK_case_user_id (user_id),
  CONSTRAINT FK_case_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT FK_case_court_id FOREIGN KEY (court_id) REFERENCES courts (court_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE descriptions (
  case_id bigint(20) NOT NULL,
  description_text varchar(255) DEFAULT NULL,
  description_date datetime NOT NULL,
  PRIMARY KEY (case_id,description_date),
  CONSTRAINT FK_description_case_id FOREIGN KEY (case_id) REFERENCES cases (case_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE roles (
  user_id bigint(20) NOT NULL,
  role_id int(11) NOT NULL,
  KEY FK_user_id (user_id),
  CONSTRAINT FK_role_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

