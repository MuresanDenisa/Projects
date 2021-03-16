----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/22/2020 04:57:19 PM
-- Design Name: 
-- Module Name: unitateControlInmultitorDublariInjumatatiri - Behavioral
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

entity unitateControlInmultitorDublariInjumatatiri is
Port ( Clk, Rst, Start: in STD_LOGIC;
        B: in STD_LOGIC_VECTOR(15 downto 0);
        LoadP, LoadAuxQ, LoadB, LoadQ,LoadX, LoadY: out STD_LOGIC;
        RstP, Stop: out STD_LOGIC );
end unitateControlInmultitorDublariInjumatatiri;

architecture Behavioral of unitateControlInmultitorDublariInjumatatiri is
type state is (startState,idle,init,checkB,decision,even,add,finish, stopState);
signal currentState: state:=startState;

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
            currentState <= checkB;
         when checkB =>    
            if ( B="0000000000000001") then
                currentState <= finish;
            else
                currentState <= decision;
            end if;
        when decision =>
            if ( B(3 downto 0)="0000" or B(3 downto 0)="0010" or B(3 downto 0)="0100" or B(3 downto 0)="0110" or B(3 downto 0)="1000") then
                currentState <= even;
            else
                currentState <= add;
            end if;
        when even =>
            currentState<= checkB;
        when add =>
             currentState <= checkB;
        when finish =>
             currentState<= stopState;
        when stopState =>
            currentState<= startState;
            Stop<='1';
        end case;
end if;
end process;
LoadX<= '1' when (currentState = init) else '0';
LoadY<= '1' when (currentState = init) else '0';
LoadP <= '1' when (currentState = add) or (currentState= finish) else '0';
LoadAuxQ <= '1' when (currentState = add) or (currentState= finish) else '0';
LoadB <= '1' when (currentState= even) or (currentState= add) else '0';
LoadQ <= '1' when (currentState = even) or (currentState=add) else '0';
RstP <= '1' when (currentState = init) else '0';
end Behavioral;
