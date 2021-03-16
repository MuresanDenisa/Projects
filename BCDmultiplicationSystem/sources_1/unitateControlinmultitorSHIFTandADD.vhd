----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/18/2020 04:45:22 PM
-- Design Name: 
-- Module Name: unitateControlinmultitorSHIFTandADD - Behavioral
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
use ieee.numeric_std.ALL;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity unitateControlinmultitorSHIFTandADD is
Port ( Clk, Rst, Start: in STD_LOGIC;
        Q0: in STD_LOGIC_VECTOR(3 downto 0);
        LoadA, LoadB, LoadQ, LoadQ0: out STD_LOGIC;
        RstA, loadT, ShrAQ, Stop: out STD_LOGIC );
end unitateControlinmultitorSHIFTandADD;

architecture Behavioral of unitateControlinmultitorSHIFTandADD is
type state is (startState,idle,init,updateQ,decision,add,shift, stopState);
signal currentState: state:=startState;
signal c: NATURAL;
signal auxQ: STD_LOGIC_VECTOR(3 downto 0);
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
            currentState <= updateQ;
        when updateQ =>
            currentState <= decision;
        when decision =>
            if (auxQ="0000") then
                currentState <= shift;
            else
                currentState <= add;
            end if;
        when add =>
             currentState <= decision;
        when shift =>
            if(c=0) then
                currentState<= stopState;
            else
                currentState<= updateQ;
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

auxQupdate:process (Clk)
begin
    if (rising_edge(Clk)) then
        if (currentState = updateQ)then
            auxQ<=Q0;
        elsif (currentState = add) then
             auxQ<= STD_LOGIC_VECTOR(unsigned(auxQ) - "0001");
        end if;
    end if;
end process;

LoadA <= '1' when (currentState = add) or (currentState = init) else '0';
LoadB <= '1' when (currentState = add) or(currentState = init) else '0';
LoadQ <= '1' when (currentState = init) else '0';
Loadq0<='1' when (currentState = init) or (currentState = shift) else '0';
RstA <= '1' when (currentState = init) else '0';
ShrAQ <= '1' when (currentState = shift) else '0';
loadT<='1' when (currentState = add) else '0';
end Behavioral;

