Comment \/\/[^$]*
IgnoreEverythingElse (.|\n)

%option noyywrap
%option yylineno

%%

{Comment} { printf("Zeilenkomment bei Zeile %d:\n%s\n", yylineno, yytext); }
{IgnoreEverythingElse}

%%

int main(int argc, char **argv) {

    yylex();
    return 0;
}