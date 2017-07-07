CREATE TABLE users (
	`id` INT NOT NULL AUTO_INCREMENT,
	`email` varchar(200) NOT NULL,
    `password` varchar(200) NOT NULL,
    `description` varchar(4000),
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX `email_idx` ON users (email);

INSERT INTO users (email, password, description) VALUES
('admin@gmail.com', '$2a$10$i0Rxqx8wD8dBLUZ8ShC7KeW454kSA/5Y3IEW3ezheLrT2x/PBRiES', 'Administrator');

CREATE TABLE roles (
	`id` INT,
    `name` varchar(200) NOT NULL,
    `description` varchar(4000),
    PRIMARY KEY (id)
);

INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

CREATE TABLE user_roles (
	user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id)
);

ALTER TABLE user_roles ADD constraint user_roles_user_fk FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE user_roles ADD constraint user_roles_role_fk FOREIGN KEY (role_id) REFERENCES roles(id);

CREATE TABLE permissions (
	`id` INT,
    `name` varchar(200) NOT NULL,
	`description` varchar(4000),
    PRIMARY KEY (id)
);

CREATE TABLE role_permissions (
	role_id INT,
    permission_id INT
);

ALTER TABLE role_permissions ADD constraint role_permissions_role_fk FOREIGN KEY (role_id) REFERENCES roles(id);
ALTER TABLE role_permissions ADD constraint role_permissions_permission_fk FOREIGN KEY (permission_id) REFERENCES permissions(id);

INSERT INTO permissions (id, name) VALUES (1, 'CREATE_USER');

CREATE TABLE advertisements (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(200) NOT NULL,
    `description` varchar(4000),
    `price` varchar(200),
    PRIMARY KEY (id)
);

COMMIT;