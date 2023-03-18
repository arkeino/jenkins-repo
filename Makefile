

##
## EPITECH PROJECT, 2021
## make
## File description:
## file
##

SRC	=	bsq.c \

NAME	=	bsq

all:	$(NAME) clean

$(NAME):
	@gcc -o $(NAME) $(SRC) -g
	@echo -e "\033[05m\033[32mCompilation done => ${NAME}\033[00m"

clean:
	rm -f

fclean:	clean
	rm -f $(NAME)
	clear

re:	fclean all
