create database test1;
use test1;

CREATE TABLE IF NOT EXISTS `register` (
`id` int(10) NOT NULL AUTO_INCREMENT,
`name` varchar(100) NOT NULL,
`password` varchar(100) NOT NULL,
`email` varchar(100) NOT NULL,
`sex` varchar(100) NOT NULL,
`country` varchar(100) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

INSERT INTO `register` (`id`, `name`, `password`, `email`, `sex`, `country`) VALUES
(17, 'arun', 'kumar', 'arun@gmail.com', 'Male', 'India'),
(19, 'sonoo', 'jaiswal', 'sonoo@javatpoint.com', 'male', 'India'),
(20, 'Ashok', 'ashok', 'ashok@javatpoint.com', 'male', 'India');
select * from register;