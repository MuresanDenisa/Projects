----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/23/2020 04:20:56 PM
-- Design Name: 
-- Module Name: modulPrincipal - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_SIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity modulPrincipal is
Port (Clk, Rst, Start, Save: in STD_LOGIC;
S: in STD_LOGIC_VECTOR(15 downto 0);
Sel: in STD_LOGIC_VECTOR(1 downto 0);
An: out STD_LOGIC_VECTOR(7 downto 0);
Seg: out STD_LOGIC_VECTOR(7 downto 0);
Stop: out STD_LOGIC );
end modulPrincipal;

architecture Behavioral of modulPrincipal is
signal X,Y,A1, Q1, A2, Q2, A3, Q3, A4, Q4: STD_LOGIC_VECTOR(15 downto 0):= (others => '0');
signal Stop1, Stop2, Stop3, Stop4, auxStop:STD_LOGIC:='0';
signal startBtn, saveBtn: STD_LOGIC;
signal selModeBtn: STD_LOGIC_VECTOR (1 downto 0);
signal P: STD_LOGIC_VECTOR(31 downto 0);
signal res: INTEGER:=0;
signal result: STD_LOGIC_VECTOR(31 downto 0);
begin

-- -------------------- DEBOUNCE BUTOANE -------------------------------------------
startB: entity WORK.debounce port map(Clk=>Clk,Rst=>Rst,din=>Start,qout=>startBtn);
saveB: entity WORK.debounce port map(Clk=>Clk,Rst=>Rst,din=>Save,qout=>saveBtn);
selModeB0: entity WORK.debounce port map(Clk=>Clk,Rst=>Rst,din=>sel(0),qout=>selModeBtn(0));
selModeB1: entity WORK.debounce port map(Clk=>Clk,Rst=>Rst,din=>sel(1),qout=>selModeBtn(1));

-- ----------------------- TRANSF REZ IN BINAR PT AFISARE ------------------------------
tranfRez: entity WORK.toInteger port map (Clk=>Clk, Rst=>Rst, Start=>auxStop, X=>P, Res=>res);
result<= CONV_STD_LOGIC_VECTOR(res, 32);

-- ---------------------- AFISARE REZULTAT ----------------------------------------------
display: entity WORK.displ7seg port map(Clk=>Clk,Rst=>Rst,Data=>result,An=>An,Seg=>Seg);   

-- ------------------ METODELE DE INMULTIRE ZECIMALA ------------------------------------
russianPeasent: entity WORK.inmultitorDublariInjumatatiri port map( X=>X, Y=>Y, A=>A1, Q=>Q1, Clk=>Clk, Rst=>Rst, Start=>StartBtn, Stop=>Stop1);
leftRightComponents: entity WORK.inmultitorComponenteSD port map( X=>X, Y=>Y, A=>A2, Q=>Q2, Clk=>Clk, Rst=>Rst, Start=>StartBtn, Stop=>Stop2);
shiftAndAdd: entity WORK.inmultitorSHIFTandADD port map( X=>X, Y=>Y, A=>A3, Q=>Q3, Clk=>Clk, Rst=>Rst, Start=>StartBtn, Stop=>Stop3);
nineMultiples: entity WORK.inmultitor9multiplii port map( X=>X, Y=>Y, A=>A4, Q=>Q4, Clk=>Clk, Rst=>Rst, Start=>StartBtn, Stop=>Stop4);

-- -------------- PROCES DE INTRODUCERE NUMERE -------------------------------
numbersProcess: process (Clk)
begin
    if rising_edge(Clk) then
        if (Rst='1')then
            X<= (others =>'0');
            Y<= (others =>'0');
        else
            if (SaveBtn='1') then
                X<=S;
            end if;    
            if (StartBtn='1') then
                Y<=S;
            end if;
        end if;
    end if;
end process;
-- ----------------- PROCES DE SELECTIE A METODEI DE CALCUL -----------------------------
selectProcess: process (Clk)
begin
    if rising_edge(Clk) then
        if (Rst='1')then
            P<= (others =>'0');
        else
            case selModeBtn is
                when "00" => P<= A4&Q4; -- nine multiples
                             auxStop<=Stop4;
                when "01" => P<= A2&Q2; -- left and right components
                             auxStop<=Stop2;
                when "10" => P<= A1&Q1; -- russian peasent
                             auxStop<=Stop1;
                when "11" => P<= A3&Q3; -- shift and add
                             auxStop<=Stop3;
                when others =>
            end case;
        end if;
    end if;
 Stop<= auxStop;
end process;  
                               
end Behavioral;