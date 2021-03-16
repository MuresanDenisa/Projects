----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/30/2020 12:55:12 PM
-- Design Name: 
-- Module Name: unitateControlInmultitorCompSD - Behavioral
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity unitateControlInmultitorCompSD is
Port ( Clk, Rst, Start: in STD_LOGIC;
        C, LoadB, LoadQ, LoadQ0: out STD_LOGIC;
        RstA, RstT, loadT1, loadT2, ShrA, ShrQ, ShrB, Stop: out STD_LOGIC );
end unitateControlInmultitorCompSD;

architecture Behavioral of unitateControlInmultitorCompSD is
type state is (startState,idle,init,decision,loadQ0State,add,updateT,shift,stopState);
signal currentState: state:=startState;
signal c0, c1: NATURAL;
begin

statesTransaction:process(Clk)
begin
if(rising_edge(Clk)) then
    case currentState is
        when startState =>
            if (Rst='1') then
                currentState<= idle;
                Stop<='0';
            end if;
        when idle =>
            if (Start = '1' ) then
                currentState <= init;
            end if;
        when init => 
            currentState <= loadQ0State;
        when loadQ0State =>
            currentState <= decision;
        when decision =>
            currentState <= add;
        when add =>
            currentState <= updateT;
        when updateT =>
            if (c1 =-1 )then
                currentState<= shift;
            else
                currentState <= decision;
            end if;
        when shift =>
            if (c0=0 )then
                currentState<= stopState;
            else
                currentState <= loadQ0State;
            end if;
        when stopState =>
            currentState<= startState;
            Stop<='1';
        end case;
end if;
end process;

counter: process (Clk)
begin
    if (rising_edge(Clk)) then
        if (currentState = idle) then
            c0<=3;
            c1<=4;
        elsif (currentState = shift) then
            c0<=c0-1;
            c1<=4;
        elsif (currentState = add) then
            c1<=c1-1;
        end if;
    end if;
end process;

LoadB <= '1' when (currentState = init) else '0';
LoadQ <= '1' when (currentState = init) else '0';
C <= '0' when (c1=0) else '1';
Loadq0<='1' when (currentState = loadQ0State) else '0';
RstA <= '1' when (currentState = init) else '0';
RstT <= '1' when (currentState = init) else '0';
ShrA <= '1' when (currentState = add) else '0';
ShrB<='1' when (currentState = add)and (c1>0) else '0';
ShrQ<='1' when (currentState = add)and (c1=0) else '0';
loadT1<='1' when (currentState = updateT)else '0';
loadT2<='1' when (currentState = updateT)else '0';
end Behavioral;
