----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/20/2020 12:37:16 PM
-- Design Name: 
-- Module Name: testBenchInmultitorShiftandAdd - Behavioral
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
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity testBenchInmultitorShiftandAdd is
--  Port ( );
end testBenchInmultitorShiftandAdd;

architecture Behavioral of testBenchInmultitorShiftandAdd is
signal Clk, Rst, Start: STD_LOGIC:='0';
signal X, Y: STD_LOGIC_VECTOR(15 downto 0):= (others => '0');
signal A, Q: STD_LOGIC_VECTOR(15 downto 0):= (others => '0');
signal Stop: STD_LOGIC;
constant clockPeriod : time := 20 ns;
begin

clk_process: process
begin
    Clk <= '0';
    wait for clockPeriod/2;
    Clk <= '1';
    wait for clockPeriod/2;
end process;

DUT: entity WORK.inmultitorSHIFTandADD port map( X=>X, Y=>Y, A=>A, Q=>Q, Clk=>Clk, Rst=>Rst, Start=>Start, Stop=>Stop);

testBench: process
begin

     X(3 downto 0) <= CONV_STD_LOGIC_VECTOR(0, 4);
     X(7 downto 4) <= CONV_STD_LOGIC_VECTOR(0, 4);
     X(11 downto 8) <= CONV_STD_LOGIC_VECTOR(9,4);
     X(15 downto 12) <= CONV_STD_LOGIC_VECTOR(0, 4);
     Y(3 downto 0) <= CONV_STD_LOGIC_VECTOR(5, 4);
     Y(7 downto 4) <= CONV_STD_LOGIC_VECTOR(1, 4);
     Y(11 downto 8) <= CONV_STD_LOGIC_VECTOR(0, 4);
     Y(15 downto 12) <= CONV_STD_LOGIC_VECTOR(0, 4);
     wait for clockPeriod;
     Rst<='1';
     wait for clockPeriod;
     Rst<='0';
     wait for clockPeriod;
     Start<='1';
     wait until Stop='1';
     
     X(3 downto 0) <= CONV_STD_LOGIC_VECTOR(5, 4);
     X(7 downto 4) <= CONV_STD_LOGIC_VECTOR(4, 4);
     X(11 downto 8) <= CONV_STD_LOGIC_VECTOR(9,4);
     X(15 downto 12) <= CONV_STD_LOGIC_VECTOR(1, 4);
     Y(3 downto 0) <= CONV_STD_LOGIC_VECTOR(3, 4);
     Y(7 downto 4) <= CONV_STD_LOGIC_VECTOR(3, 4);
     Y(11 downto 8) <= CONV_STD_LOGIC_VECTOR(7, 4);
     Y(15 downto 12) <= CONV_STD_LOGIC_VECTOR(5, 4);
     wait for clockPeriod;
     Rst<='1';
     wait for clockPeriod;
     Rst<='0';
     wait for clockPeriod;
     Start<='1';
     wait until Stop='1';
     
     X(3 downto 0) <= CONV_STD_LOGIC_VECTOR(9, 4);
     X(7 downto 4) <= CONV_STD_LOGIC_VECTOR(9, 4);
     X(11 downto 8) <= CONV_STD_LOGIC_VECTOR(9,4);
     X(15 downto 12) <= CONV_STD_LOGIC_VECTOR(9, 4);
     Y(3 downto 0) <= CONV_STD_LOGIC_VECTOR(9, 4);
     Y(7 downto 4) <= CONV_STD_LOGIC_VECTOR(9, 4);
     Y(11 downto 8) <= CONV_STD_LOGIC_VECTOR(9, 4);
     Y(15 downto 12) <= CONV_STD_LOGIC_VECTOR(9, 4);
     wait for clockPeriod;
     Rst<='1';
     wait for clockPeriod;
     Rst<='0';
     wait for clockPeriod;
     Start<='1';
     wait until Stop='1';
     
     wait;
end process;
end Behavioral;
