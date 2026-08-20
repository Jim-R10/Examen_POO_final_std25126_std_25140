CREATE DATABASE "Donation";


CREATE TYPE expense_frequency AS ENUM ('NONE', 'MONTHLY', 'WEEKLY', 'YEARLY');

CREATE TABLE "User" (
                        id          VARCHAR(36)  NOT NULL,
                        ref         VARCHAR(50)  NOT NULL,
                        "firstName" VARCHAR(100) NOT NULL,
                        "lastName"  VARCHAR(100) NOT NULL,
                        email       VARCHAR(150) NOT NULL,
                        phone       VARCHAR(20),
                        PRIMARY KEY (id),
                        UNIQUE (ref),
                        UNIQUE (email)
);

CREATE TABLE "CashFlow" (
                            id          VARCHAR(36)    NOT NULL,
                            "createdAt" TIMESTAMP      NOT NULL,
                            amount      DECIMAL(12,2)  NOT NULL,
                            user_id     VARCHAR(36)    NOT NULL,
                            PRIMARY KEY (id),
                            CONSTRAINT fk_cashflow_user
                                FOREIGN KEY (user_id) REFERENCES "User"(id)
                                    ON DELETE CASCADE
);

CREATE TABLE "Donation" (
                            id          VARCHAR(36)  NOT NULL,
                            comment     VARCHAR(255),
                            PRIMARY KEY (id),
                            CONSTRAINT fk_donation_cashflow
                                FOREIGN KEY (id) REFERENCES "CashFlow"(id)
                                    ON DELETE CASCADE
);


CREATE TABLE "Expense" (
                           id          VARCHAR(36)         NOT NULL,
                           reason      VARCHAR(255)        NOT NULL,
                           frequency   expense_frequency   NOT NULL DEFAULT 'NONE',
                           PRIMARY KEY (id),
                           CONSTRAINT fk_expense_cashflow
                               FOREIGN KEY (id) REFERENCES "CashFlow"(id)
                                   ON DELETE CASCADE
);
