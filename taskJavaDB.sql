CREATE DATABASE IF NOT EXISTS taskJava DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE taskJava;
-- Création de la table 'category'
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Création de la table 'account'
CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Création de la table 'task'
CREATE TABLE task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    createAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    status TINYINT(1) NOT NULL,
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(id)
);

-- Création de la table 'task_category'
CREATE TABLE task_category (
    task_id INT,
    category_id INT,
    PRIMARY KEY (task_id, category_id),
    FOREIGN KEY (task_id) REFERENCES task(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

INSERT INTO category (name) VALUE ('Développement');
INSERT INTO category (name) VALUE ('Design');
INSERT INTO category (name) VALUE ('Marketing');

INSERT INTO task (title, description, createAt, status, account_id)
VALUES 
('Créer un site web', 'Développer un site web pour un client', NOW(), 0, 1), 
('Concevoir un logo', 'Créer un logo pour une entreprise', NOW(), 1, 1), 
('Lancer une campagne', 'Préparer une campagne marketing', NOW(), 0, 1);

INSERT INTO task_category (task_id, category_id) 
VALUES 
(1, 1),  -- Associer 'Créer un site web' à 'Développement'
(2, 2), -- Associer 'Concevoir un logo' à 'Design'
(3, 3); -- Associer 'Lancer une campagne' à 'Marketing'

SELECT title, status FROM task;
