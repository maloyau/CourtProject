INSERT INTO users (email, password, username, active) VALUES ('admin@gmail.com', '$2a$04$m/Wt2Ayz.udHMZNuf/Nuc.bik61A6knckthBTrS7ca/shuVlTNZbO', 'admin', TRUE);
INSERT INTO users (email, password, username, active) VALUES ('user@gmail.com', '$2a$04$m/Wt2Ayz.udHMZNuf/Nuc.bik61A6knckthBTrS7ca/shuVlTNZbO', 'user', FALSE );
INSERT INTO roles (user_id, role_name) VALUES (1, "ADMIN");
INSERT INTO roles (user_id, role_name) VALUES (2, "USER");