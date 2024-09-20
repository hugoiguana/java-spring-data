CREATE TYPE test.products_categories_view AS (
                                                 id UUID,
                                                 "name" varchar,
                                                 description varchar,
                                                 category_id UUID,
                                                 category_name varchar
                                             );