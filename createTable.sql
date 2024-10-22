-- 创建用户表
CREATE TABLE user (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      email VARCHAR(100) NOT NULL UNIQUE,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建民宿表
CREATE TABLE homestay (
                          homestay_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          title VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          address VARCHAR(255) NOT NULL,
                          available_from DATE,
                          available_to DATE,
                          image_url VARCHAR(255),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES user(user_id)
);

-- 创建预订表
CREATE TABLE booking (
                         booking_id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id INT NOT NULL,
                         homestay_id INT NOT NULL,
                         start_date DATE NOT NULL,
                         end_date DATE NOT NULL,
                         status ENUM('pending', 'confirmed', 'cancelled') NOT NULL DEFAULT 'pending',
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES user(user_id),
                         FOREIGN KEY (homestay_id) REFERENCES homestay(homestay_id)
);

-- 创建评价表
CREATE TABLE review (
                        review_id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT NOT NULL,
                        homestay_id INT NOT NULL,
                        rating INT NOT NULL,
                        comment TEXT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES user(user_id),
                        FOREIGN KEY (homestay_id) REFERENCES homestay(homestay_id)
);

-- 创建积分表
CREATE TABLE point (
                       point_id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT NOT NULL,
                       amount INT NOT NULL DEFAULT 0,
                       description VARCHAR(255),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES user(user_id)
);