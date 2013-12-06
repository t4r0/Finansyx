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
percentage = {integer}['%']

%%

<YYINITIAL>
{
    "activos" {return Symbol(sym.ASSETS);}
    "anterior" {return Symbol(sym.LAST);}
    "aleman"  {return Symbol(sym.GERMAN);}
    "arbol"   {return Symbol(sym.TREE);} 
    "bruto"   {return Symbol(sym.GROSS);}
    "costos"  {return Symbol(sym.COSTS);}       
    "escalonados" {return Symbol(sym.TIERED);}
    "escenario"   {return Symbol(sym.SCENARIO);}
    "fin"         { return Symbol(sym.END);}  
    "flujo"       { return Symbol(sym.FLOW);}  
    "frances"     { return Symbol(sym.FRENCH);}
    "gastos"      { return Symbol(sym.OUTLAY);}
    "info"        { return Symbol(sym.INFO);}
    "inicial"     { return Symbol(sym.FIRST);}
    "inferior"    { return Symbol(sym.INF); }
    "infer-min"   { return Symbol(sym.INFMIN);}
    "ingresos"    { return Symbol(sym.REVENUE);}  
    "intereses"   { return Symbol(sym.INTERESTS);}
    "neto"        { return Symbol(sym.NET); }
    "patente"     { return Symbol(sym.PATENT); }
    "pronosticar" { return Symbol(sym.PROGNOSTIC); } 
    "no"          { return Symbol(sym.NO, false); } 
    "optimo"      { return Symbol(sym.OPTIMIZER); }  
    "si"          { return Symbol(sym.YES, true); }  
    "super"       { return Symbol(sym.UPPER); }  
    "super-min"   { return Symbol(sym.UPPER-MIN); }  
    "tmar"        { return Symbol(sym.MARR); }  
    "("           { return Symbol(sym.OPBRAC); } 
    ")"           { return Symbol(sym.CLBRAC); }  
    "+"           { return Symbol(sym.PLUS); }  
    "-"           { return Symbol(sym.MINUS); }  
    "*"           { return Symbol(sym.TIMES); }  
    "/"           { return Symbol(sym.DIVIDE); }  
    ":"           { return Symbol(sym.POLKADOT); }
    "{"           { return Symbol(sym.OPCURLYBRAC); }
    "}"           { return Symbol(sym.CLCURLYBRAC); } 
    ","           { return Symbol(sym.COMMA); }  
    "["           { return Symbol(sym.OPSQBRAC);}  
    "]"           { return Symbol(sym.CLSQBRAC); }
    ";"           { return Symbol(sym.SEMICOLON); }
    "="           { return Symbol(sym.EQUALS); }
    "->"          { return Symbol(sym.POINTER); } 
    {integer}     { return Symbol(sym.INTEGER, new Integer(yytext()));}
    {floating}    { return Symbol(sym.FLOAT, new Double(yytext()));} 
    {identifier}  { return Symbol(sym.IDENTIFIER, yytext()); }
    {percentage}  { return Symbol(sym.PERCENTAGE,yytext()); }
    {whiteSpace}  {/* ignoring */}
    {newLine}     {/* ignoring */}
    . {System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");}
}

    