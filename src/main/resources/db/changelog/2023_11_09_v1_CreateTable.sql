CREATE TABLE houses (
                        id BIGSERIAL PRIMARY KEY ,
                        address_f VARCHAR(60) NOT NULL,
                        master_id BIGINT NOT NULL
);
CREATE TABLE users (
                          id BIGSERIAL PRIMARY KEY ,
                          name VARCHAR(60) NOT NULL,
                          password VARCHAR(60) NOT NULL,
                          age INTEGER NOT NULL,
                          house_id BIGINT,
                          FOREIGN KEY (house_id) REFERENCES houses(id)
);
ALTER TABLE houses
    ADD CONSTRAINT houses_user_fk
        FOREIGN KEY (master_id) REFERENCES users(id);