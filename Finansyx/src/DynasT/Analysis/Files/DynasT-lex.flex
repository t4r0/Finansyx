package DynasT.Analysis.Classes;

import java_cup.runtime.Symbol;

%%
%class LexicalAnalyzer
%public
%line
%column
%cup
%ignorecase
%type java_cup.runtime.Symbol
%eofval{
  return new Symbol(sym.EOF);
%eofval}

newLine = \n|\r|\n\r
whiteSpace = [ \t\f]
integer = [0-9]+
floating = {integer}[\.]{integer} 
identifier = [:jletter:][:jletterdigit:]* 
numb = {integer} | {floating}
percentage = {numb}['%'] 
%%

<YYINITIAL>
{
    "activos" {return new Symbol(sym.ASSETS);}
    "anterior" {return new Symbol(sym.LAST);}
    "aleman"  {return new Symbol(sym.GERMAN);}
    "arbol"   {return new Symbol(sym.TREE);} 
    "bruto"   {return new Symbol(sym.GROSS);}
    "costos"  {return new Symbol(sym.COSTS);}       
    "escalonados" {return new Symbol(sym.TIERED);}
    "escenario"   {return new Symbol(sym.SCENARIO);}
    "fin"         { return new Symbol(sym.END);}  
    "flujo"       { return new Symbol(sym.FLOW);}  
    "frances"     { return new Symbol(sym.FRENCH);}
    "gastos"      { return new Symbol(sym.OUTLAY);}
    "info"        { return new Symbol(sym.INFO);}
    "inicio"      { return new Symbol(sym.START);}
    "inicial"     { return new Symbol(sym.FIRST);}
    "inferior"    { return new Symbol(sym.INF); }
    "infer-min"   { return new Symbol(sym.INFMIN);}
    "ingresos"    { return new Symbol(sym.REVENUE);}  
    "intereses"   { return new Symbol(sym.INTERESTS);}
    "neto"        { return new Symbol(sym.NET); }
    "patente"     { return new Symbol(sym.PATENT); }
    "pronosticar" { return new Symbol(sym.PROGNOSTIC); } 
    "no"          { return new Symbol(sym.NO, false); } 
    "optimo"      { return new Symbol(sym.OPTIMIZER); }  
    "si"          { return new Symbol(sym.YES, true); }  
    "super"       { return new Symbol(sym.UPPER); }  
    "super-min"   { return new Symbol(sym.UPPER_MIN); }  
    "tmar"        { return new Symbol(sym.MARR); }  
    "("           { return new Symbol(sym.OPBRAC); } 
    ")"           { return new Symbol(sym.CLBRAC); }  
    "+"           { return new Symbol(sym.PLUS); }  
    "-"           { return new Symbol(sym.MINUS); }  
    "*"           { return new Symbol(sym.TIMES); }  
    "/"           { return new Symbol(sym.DIVIDE); }  
    ":"           { return new Symbol(sym.POLKADOT); }
    "{"           { return new Symbol(sym.OPCURLYBRAC); }
    "}"           { return new Symbol(sym.CLCURLYBRAC); } 
    ","           { return new Symbol(sym.COMMA); }  
    "["           { return new Symbol(sym.OPSQBRAC);}  
    "]"           { return new Symbol(sym.CLSQBRAC); }
    ";"           { return new Symbol(sym.SEMICOLON); }
    "="           { return new Symbol(sym.EQUALS); }
    "->"          { return new Symbol(sym.POINTER); } 
    {numb}        { return new Symbol(sym.NUMBER, new Double(yytext()));} 
    {identifier}  { return new Symbol(sym.IDENTIFIER, yytext()); }
    {percentage}  { return new Symbol(sym.PERCENTAGE,yytext()); }
    {whiteSpace}  {/* ignoring */}
    {newLine}     {/* ignoring */}
    . {System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");}
}

    