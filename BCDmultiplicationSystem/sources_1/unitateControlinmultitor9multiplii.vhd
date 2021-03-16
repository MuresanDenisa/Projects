----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/13/2020 04:12:32 PM
-- Design Name: 
-- Module Name: unitateControlinmultitor9multiplii - Behavioral
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

entity unitateControlinmultitor9multiplii is
Port ( Clk, Rst, Start: in STD_LOGIC;
        Q0: in STD_LOGIC_VECTOR(3 downto 0);
        LoadA, LoadB, LoadQ, LoadQ0: out STD_LOGIC;
        RstA, loadT, ShrAQ, Stop: out STD_LOGIC );
end unitateControlinmultitor9multiplii;

architecture Behavioral of unitateControlinmultitor9multiplii is
type state is (startState,idle,init,decision,add,shift, stopState);
signal currentState: state:=startState;
signal c: NATURAL;
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
            currentState <= decision;
        when decision =>
            if (Q0="0000") then
                currentState <= shift;
            else
                currentState <= add;
            end if;
        when add =>
            currentState <= shift;
        when shift =>
            if(c=0) then
                currentState<= stopState;
            else
                currentState<= decision;
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
            c<=4;
        elsif (currentState = shift) then
            c<=c-1;
        end if;
    end if;
end process;

LoadA <= '1' when (currentState = add) or (currentState = init) else '0';
LoadB <= '1' when (currentState = init) else '0';
LoadQ <= '1' when (currentState = init) else '0';
Loadq0<='1' when (currentState = init) or (currentState = shift) else '0';
RstA <= '1' when (currentState = init) else '0';
ShrAQ <= '1' when (currentState = shift) else '0';
loadT<='1' when (currentState = add) else '0';
end Behavioral;
