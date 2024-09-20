
INSERT INTO test.category
(id, "name", description, dt_criation, dt_modification, deleted)
VALUES(gen_random_uuid(), 'category2', 'category', current_timestamp, current_timestamp, false),
      (gen_random_uuid(), 'category1', 'category', current_timestamp, current_timestamp, false);

INSERT INTO test.product
(id, "name", description, dt_criation, dt_modification, deleted, id_category)
VALUES(gen_random_uuid(), 'product1', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category1')),
      (gen_random_uuid(), 'product2', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category1')),
      (gen_random_uuid(), 'product3', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category1')),
      (gen_random_uuid(), 'product4', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category1')),
      (gen_random_uuid(), 'product5', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category1')),
      (gen_random_uuid(), 'product6', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category2')),
      (gen_random_uuid(), 'product7', 'product', current_timestamp, current_timestamp, false, (select c.id from test.category c where c."name" = 'category2'));
