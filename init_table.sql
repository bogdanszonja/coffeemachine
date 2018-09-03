CREATE TABLE public.orders
(
    id serial PRIMARY KEY,
    costumer_name varchar,
    costumer_room varchar,
    coffe_type varchar,
    order_time timestamp
);