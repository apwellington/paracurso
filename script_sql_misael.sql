CREATE TABLE categoria(
    id BIGINT AUTO_INCREMENT NOT NULL,
    nonbre VARCHAR(45),
    descripcion VARCHAR(145),
    PRIMARY KEY(id)
    );
    
    	CREATE TABLE producto(
    id BIGINT AUTO_INCREMENT NOT NULL,
    nonbre VARCHAR(45),
    precio DOUBLE(10,2),
    categoria_id BIGINT NOT NULL,
    PRIMARY KEY(id),

    FOREIGN KEY(categoria_id) REFERENCES categoria(id)
    );
    
        	CREATE TABLE stock(
    id BIGINT AUTO_INCREMENT NOT NULL,
    cantidad VARCHAR(45),
    fecha Date,
    produto_id BIGINT NOT NULL,
    PRIMARY KEY(id),

    FOREIGN KEY(produto_id) REFERENCES produto(id)
    );                          
