INSERT INTO kitchen (name) VALUES ('Tailandesa');
INSERT INTO kitchen (name) VALUES ('Indiana');

INSERT INTO restaurant (name, shipping_fee, kitchen_id) VALUES ('Restaurante 1', 10.98, 1);
INSERT INTO restaurant (name, shipping_fee, kitchen_id) VALUES ('Restaurante 2', 7.77, 2);
INSERT INTO restaurant (name, shipping_fee, kitchen_id) VALUES ('Restaurante 3', 10.98, 1);

INSERT INTO payment_method (description) VALUES ('Dinheiro');
INSERT INTO payment_method (description) VALUES ('Cartão de crédito');
INSERT INTO payment_method (description) VALUES ('Cartão de débito');

INSERT INTO state (name) VALUES ('São Paulo');
INSERT INTO state (name) VALUES ('Rio de Janeiro');
INSERT INTO state (name) VALUES ('Minas Gerais');
INSERT INTO state (name) VALUES ('Paraná');
INSERT INTO state (name) VALUES ('Santa Catarina');

INSERT INTO city (name, state_id) VALUES ('São Paulo', 1);
INSERT INTO city (name, state_id) VALUES ('Rio de Janeiro', 2);
INSERT INTO city (name, state_id) VALUES ('Belo Horizonte', 3);
INSERT INTO city (name, state_id) VALUES ('Curitiba', 4);
INSERT INTO city (name, state_id) VALUES ('Florianópolis', 5);

INSERT INTO role (name, description) VALUES ('ROLE_ADMIN', 'Administrador');
INSERT INTO role (name, description) VALUES ('ROLE_USER', 'Usuário');
